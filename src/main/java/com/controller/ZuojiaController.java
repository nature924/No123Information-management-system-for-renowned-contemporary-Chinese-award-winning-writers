
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
 * 作家
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zuojia")
public class ZuojiaController {
    private static final Logger logger = LoggerFactory.getLogger(ZuojiaController.class);

    private static final String TABLE_NAME = "zuojia";

    @Autowired
    private ZuojiaService zuojiaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    @Autowired
    private ZuojiaCollectionService zuojiaCollectionService;

    //级联表非注册的service
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
        params.put("zuojiaDeleteStart",1);params.put("zuojiaDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zuojiaService.queryPage(params);

        //字典表数据转换
        List<ZuojiaView> list =(List<ZuojiaView>)page.getList();
        for(ZuojiaView c:list){
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
        ZuojiaEntity zuojia = zuojiaService.selectById(id);
        if(zuojia !=null){
            //entity转view
            ZuojiaView view = new ZuojiaView();
            BeanUtils.copyProperties( zuojia , view );//把实体数据重构到view中
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
    public R save(@RequestBody ZuojiaEntity zuojia, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zuojia:{}",this.getClass().getName(),zuojia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZuojiaEntity> queryWrapper = new EntityWrapper<ZuojiaEntity>()
            .eq("zuojia_name", zuojia.getZuojiaName())
            .eq("zuojia_types", zuojia.getZuojiaTypes())
            .eq("zuojia_minzu", zuojia.getZuojiaMinzu())
            .eq("zuojia_jiguan", zuojia.getZuojiaJiguan())
            .eq("zuojia_daibia", zuojia.getZuojiaDaibia())
            .eq("zuojia_delete", zuojia.getZuojiaDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuojiaEntity zuojiaEntity = zuojiaService.selectOne(queryWrapper);
        if(zuojiaEntity==null){
            zuojia.setZuojiaDelete(1);
            zuojia.setInsertTime(new Date());
            zuojia.setCreateTime(new Date());
            zuojiaService.insert(zuojia);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZuojiaEntity zuojia, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zuojia:{}",this.getClass().getName(),zuojia.toString());
        ZuojiaEntity oldZuojiaEntity = zuojiaService.selectById(zuojia.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZuojiaEntity> queryWrapper = new EntityWrapper<ZuojiaEntity>()
            .notIn("id",zuojia.getId())
            .andNew()
            .eq("zuojia_name", zuojia.getZuojiaName())
            .eq("zuojia_types", zuojia.getZuojiaTypes())
            .eq("zuojia_minzu", zuojia.getZuojiaMinzu())
            .eq("zuojia_jiguan", zuojia.getZuojiaJiguan())
            .eq("zuojia_daibia", zuojia.getZuojiaDaibia())
            .eq("zuojia_delete", zuojia.getZuojiaDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuojiaEntity zuojiaEntity = zuojiaService.selectOne(queryWrapper);
        if("".equals(zuojia.getZuojiaPhoto()) || "null".equals(zuojia.getZuojiaPhoto())){
                zuojia.setZuojiaPhoto(null);
        }
        if(zuojiaEntity==null){
            zuojiaService.updateById(zuojia);//根据id更新
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
        List<ZuojiaEntity> oldZuojiaList =zuojiaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZuojiaEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZuojiaEntity zuojiaEntity = new ZuojiaEntity();
            zuojiaEntity.setId(id);
            zuojiaEntity.setZuojiaDelete(2);
            list.add(zuojiaEntity);
        }
        if(list != null && list.size() >0){
            zuojiaService.updateBatchById(list);
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
            List<ZuojiaEntity> zuojiaList = new ArrayList<>();//上传的东西
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
                            ZuojiaEntity zuojiaEntity = new ZuojiaEntity();
//                            zuojiaEntity.setZuojiaName(data.get(0));                    //作家姓名 要改的
//                            zuojiaEntity.setZuojiaUuidNumber(data.get(0));                    //作家编号 要改的
//                            zuojiaEntity.setZuojiaPhoto("");//详情和图片
//                            zuojiaEntity.setZuojiaTypes(Integer.valueOf(data.get(0)));   //获得的奖项 要改的
//                            zuojiaEntity.setZuojiaMinzu(data.get(0));                    //民族 要改的
//                            zuojiaEntity.setZuojiaJiguan(data.get(0));                    //作家籍贯 要改的
//                            zuojiaEntity.setChushengTime(sdf.parse(data.get(0)));          //出生年 要改的
//                            zuojiaEntity.setHuojiangTime(sdf.parse(data.get(0)));          //获奖时间 要改的
//                            zuojiaEntity.setZuojiaDaibia(data.get(0));                    //代表作 要改的
//                            zuojiaEntity.setZuojiaContent("");//详情和图片
//                            zuojiaEntity.setZuojiaDelete(1);//逻辑删除字段
//                            zuojiaEntity.setInsertTime(date);//时间
//                            zuojiaEntity.setCreateTime(date);//时间
                            zuojiaList.add(zuojiaEntity);


                            //把要查询是否重复的字段放入map中
                                //作家编号
                                if(seachFields.containsKey("zuojiaUuidNumber")){
                                    List<String> zuojiaUuidNumber = seachFields.get("zuojiaUuidNumber");
                                    zuojiaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zuojiaUuidNumber = new ArrayList<>();
                                    zuojiaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zuojiaUuidNumber",zuojiaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //作家编号
                        List<ZuojiaEntity> zuojiaEntities_zuojiaUuidNumber = zuojiaService.selectList(new EntityWrapper<ZuojiaEntity>().in("zuojia_uuid_number", seachFields.get("zuojiaUuidNumber")).eq("zuojia_delete", 1));
                        if(zuojiaEntities_zuojiaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZuojiaEntity s:zuojiaEntities_zuojiaUuidNumber){
                                repeatFields.add(s.getZuojiaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [作家编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zuojiaService.insertBatch(zuojiaList);
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
        PageUtils page = zuojiaService.queryPage(params);

        //字典表数据转换
        List<ZuojiaView> list =(List<ZuojiaView>)page.getList();
        for(ZuojiaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuojiaEntity zuojia = zuojiaService.selectById(id);
            if(zuojia !=null){


                //entity转view
                ZuojiaView view = new ZuojiaView();
                BeanUtils.copyProperties( zuojia , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZuojiaEntity zuojia, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zuojia:{}",this.getClass().getName(),zuojia.toString());
        Wrapper<ZuojiaEntity> queryWrapper = new EntityWrapper<ZuojiaEntity>()
            .eq("zuojia_name", zuojia.getZuojiaName())
            .eq("zuojia_uuid_number", zuojia.getZuojiaUuidNumber())
            .eq("zuojia_types", zuojia.getZuojiaTypes())
            .eq("zuojia_minzu", zuojia.getZuojiaMinzu())
            .eq("zuojia_jiguan", zuojia.getZuojiaJiguan())
            .eq("zuojia_daibia", zuojia.getZuojiaDaibia())
            .eq("zuojia_delete", zuojia.getZuojiaDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuojiaEntity zuojiaEntity = zuojiaService.selectOne(queryWrapper);
        if(zuojiaEntity==null){
            zuojia.setZuojiaDelete(1);
            zuojia.setInsertTime(new Date());
            zuojia.setCreateTime(new Date());
        zuojiaService.insert(zuojia);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
     * 个性推荐
     */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ZuojiaView> returnZuojiaViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);
        params1.put("sort","id");
        params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = zuojiaCollectionService.queryPage(params1);
        List<ZuojiaCollectionView> orderViewsList =(List<ZuojiaCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ZuojiaCollectionView orderView:orderViewsList){
            Integer shicidaquanTypes = orderView.getZuojiaTypes();
            if(typeMap.containsKey(shicidaquanTypes)){
                typeMap.put(shicidaquanTypes,typeMap.get(shicidaquanTypes)+1);
            }else{
                typeMap.put(shicidaquanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("zuojiaTypes",type);
            PageUtils pageUtils1 = zuojiaService.queryPage(params2);
            List<ZuojiaView> shicidaquanViewList =(List<ZuojiaView>)pageUtils1.getList();
            returnZuojiaViewList.addAll(shicidaquanViewList);
            if(returnZuojiaViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = zuojiaService.queryPage(params);
        if(returnZuojiaViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnZuojiaViewList.size();//要添加的数量
            List<ZuojiaView> shicidaquanViewList =(List<ZuojiaView>)page.getList();
            for(ZuojiaView shicidaquanView:shicidaquanViewList){
                Boolean addFlag = true;
                for(ZuojiaView returnShicidaquanView:returnZuojiaViewList){
                    if(returnShicidaquanView.getId().intValue() ==shicidaquanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnZuojiaViewList.add(shicidaquanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnZuojiaViewList = returnZuojiaViewList.subList(0, limit);
        }

        for(ZuojiaView c:returnZuojiaViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnZuojiaViewList);
        return R.ok().put("data", page);
    }


}
