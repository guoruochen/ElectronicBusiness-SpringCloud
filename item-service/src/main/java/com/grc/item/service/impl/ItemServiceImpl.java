package com.grc.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.grc.common.IDUtils;
import com.grc.item.domain.Item;
import com.grc.item.domain.ItemCategory;
import com.grc.item.mapper.ItemMapper;
import com.grc.item.service.ItemService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:12
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    //访问图片的url
    @Value("${application.access_base_url}")
    private String accessBaseUrl;

    //图片上传的根路径
    @Value("${application.files.localpath}")
    private String basePath;

    /*
    根据id查询商品
     */
    @Override
    public Item getItemById(Long itemId) {
        return itemMapper.getItemById(itemId);
    }

    /*
    查询商品列表
     */
    @Override
    public List<Item> getItemsPageable(int page, int rows) {
        PageHelper.startPage(page, rows);//分页处理
        return itemMapper.getItemsPageable();
    }

    /*
    选择商品类目
     */
    @Override
    public List<ItemCategory> getItemCategroy(Long parentId) {
        return itemMapper.getItemCategroy(parentId);
    }

    /*
    上传图片
     */
    @Override
    public String upload(MultipartFile uploadFile) throws IOException {
        String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        //取原始图片名(比如test.jpg)
        String oldname = uploadFile.getOriginalFilename();
        //生成新图片名(随机字符串+原始图片名的后缀)
        String newName = IDUtils.genImageName() + oldname.substring(oldname.lastIndexOf("."));
        //图片上传的相对路径
        String relPath = File.separator + "itemPics" + File.separator + date + File.separator;
        //图片上传
        FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), new File(basePath + relPath, newName));
        //访问图片的相对路径
        String relUrl = "/" + "itemPics" + "/" + date + "/" + newName;
        //返回访问图片的路径
        return accessBaseUrl + relUrl;
    }
}
