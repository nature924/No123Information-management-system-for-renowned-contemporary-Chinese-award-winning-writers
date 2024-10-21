
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 作品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zuopin")
public class ZuopinController {
    private static final Logger logger = LoggerFactory.getLogger(ZuopinController.class);

    private static final String TABLE_NAME = "zuopin";

    @Autowired
    private ZuopinService zuopinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private ZuojiaService zuojiaService;
    //注册表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("zuopinDeleteStart",1);params.put("zuopinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zuopinService.queryPage(params);

        //字典表数据转换
        List<ZuopinView> list =(List<ZuopinView>)page.getList();
        for(ZuopinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuopinEntity zuopin = zuopinService.selectById(id);
        if(zuopin !=null){
            //entity转view
            ZuopinView view = new ZuopinView();
            BeanUtils.copyProperties( zuopin , view );//把实体数据重构到view中
            //级联表 作家
            //级联表
            ZuojiaEntity zuojia = zuojiaService.selectById(zuopin.getZuojiaId());
            if(zuojia != null){
            BeanUtils.copyProperties( zuojia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZuojiaId(zuojia.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZuopinEntity zuopin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zuopin:{}",this.getClass().getName(),zuopin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZuopinEntity> queryWrapper = new EntityWrapper<ZuopinEntity>()
            .eq("zuojia_id", zuopin.getZuojiaId())
            .eq("zuopin_name", zuopin.getZuopinName())
            .eq("zuopin_types", zuopin.getZuopinTypes())
            .eq("zuopin_delete", zuopin.getZuopinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuopinEntity zuopinEntity = zuopinService.selectOne(queryWrapper);
        if(zuopinEntity==null){
            zuopin.setZuopinDelete(1);
            zuopin.setInsertTime(new Date());
            zuopin.setCreateTime(new Date());
            zuopinService.insert(zuopin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZuopinEntity zuopin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zuopin:{}",this.getClass().getName(),zuopin.toString());
        ZuopinEntity oldZuopinEntity = zuopinService.selectById(zuopin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZuopinEntity> queryWrapper = new EntityWrapper<ZuopinEntity>()
            .notIn("id",zuopin.getId())
            .andNew()
            .eq("zuojia_id", zuopin.getZuojiaId())
            .eq("zuopin_name", zuopin.getZuopinName())
            .eq("zuopin_types", zuopin.getZuopinTypes())
            .eq("zuopin_delete", zuopin.getZuopinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuopinEntity zuopinEntity = zuopinService.selectOne(queryWrapper);
        if("".equals(zuopin.getZuopinPhoto()) || "null".equals(zuopin.getZuopinPhoto())){
                zuopin.setZuopinPhoto(null);
        }
        if(zuopinEntity==null){
            zuopinService.updateById(zuopin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZuopinEntity> oldZuopinList =zuopinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZuopinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZuopinEntity zuopinEntity = new ZuopinEntity();
            zuopinEntity.setId(id);
            zuopinEntity.setZuopinDelete(2);
            list.add(zuopinEntity);
        }
        if(list != null && list.size() >0){
            zuopinService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ZuopinEntity> zuopinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZuopinEntity zuopinEntity = new ZuopinEntity();
//                            zuopinEntity.setZuojiaId(Integer.valueOf(data.get(0)));   //作家 要改的
//                            zuopinEntity.setZuopinName(data.get(0));                    //作品名称 要改的
//                            zuopinEntity.setZuopinUuidNumber(data.get(0));                    //作品编号 要改的
//                            zuopinEntity.setZuopinPhoto("");//详情和图片
//                            zuopinEntity.setZuopinTypes(Integer.valueOf(data.get(0)));   //作品类型 要改的
//                            zuopinEntity.setFabuTime(sdf.parse(data.get(0)));          //发布时间 要改的
//                            zuopinEntity.setZuopinContent("");//详情和图片
//                            zuopinEntity.setZuopinDelete(1);//逻辑删除字段
//                            zuopinEntity.setInsertTime(date);//时间
//                            zuopinEntity.setCreateTime(date);//时间
                            zuopinList.add(zuopinEntity);


                            //把要查询是否重复的字段放入map中
                                //作品编号
                                if(seachFields.containsKey("zuopinUuidNumber")){
                                    List<String> zuopinUuidNumber = seachFields.get("zuopinUuidNumber");
                                    zuopinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zuopinUuidNumber = new ArrayList<>();
                                    zuopinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zuopinUuidNumber",zuopinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //作品编号
                        List<ZuopinEntity> zuopinEntities_zuopinUuidNumber = zuopinService.selectList(new EntityWrapper<ZuopinEntity>().in("zuopin_uuid_number", seachFields.get("zuopinUuidNumber")).eq("zuopin_delete", 1));
                        if(zuopinEntities_zuopinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZuopinEntity s:zuopinEntities_zuopinUuidNumber){
                                repeatFields.add(s.getZuopinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [作品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zuopinService.insertBatch(zuopinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zuopinService.queryPage(params);

        //字典表数据转换
        List<ZuopinView> list =(List<ZuopinView>)page.getList();
        for(ZuopinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuopinEntity zuopin = zuopinService.selectById(id);
            if(zuopin !=null){


                //entity转view
                ZuopinView view = new ZuopinView();
                BeanUtils.copyProperties( zuopin , view );//把实体数据重构到view中

                //级联表
                    ZuojiaEntity zuojia = zuojiaService.selectById(zuopin.getZuojiaId());
                if(zuojia != null){
                    BeanUtils.copyProperties( zuojia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZuojiaId(zuojia.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZuopinEntity zuopin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zuopin:{}",this.getClass().getName(),zuopin.toString());
        Wrapper<ZuopinEntity> queryWrapper = new EntityWrapper<ZuopinEntity>()
            .eq("zuojia_id", zuopin.getZuojiaId())
            .eq("zuopin_name", zuopin.getZuopinName())
            .eq("zuopin_uuid_number", zuopin.getZuopinUuidNumber())
            .eq("zuopin_types", zuopin.getZuopinTypes())
            .eq("zuopin_delete", zuopin.getZuopinDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuopinEntity zuopinEntity = zuopinService.selectOne(queryWrapper);
        if(zuopinEntity==null){
            zuopin.setZuopinDelete(1);
            zuopin.setInsertTime(new Date());
            zuopin.setCreateTime(new Date());
        zuopinService.insert(zuopin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
