package com.rvakva.xklint.rules.detector;

import com.android.resources.ResourceFolderType;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Location;
import com.android.tools.lint.detector.api.ResourceContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import java.util.EnumSet;

/**
 * @Copyright (C), 2012-2019, Sichuan Xiaoka Technology Co., Ltd.
 * @FileName: XKImageFileSizeDetector
 * @Author: hufeng
 * @Date: 2019/9/25 上午10:57
 * @Description:
 * @History:
 */
public class XKImageFileSizeDetector extends Detector implements Detector.BinaryResourceScanner{

    private static final Class<? extends Detector> DETECTOR_CLASS = XKImageFileSizeDetector.class;
    private static final EnumSet<Scope> DETECTOR_SCOPE = Scope.BINARY_RESOURCE_FILE_SCOPE;
    private static final Implementation IMPLEMENTATION = new Implementation(
            DETECTOR_CLASS,
            DETECTOR_SCOPE
    );

    private static final String ISSUE_ID = "XK_ImageFileSizeInvalid";
    private static final String ISSUE_DESCRIPTION = "错误：图片文件过大";
    private static final String ISSUE_EXPLANATION = "错误：图片文件过大，请压缩你的图片文件。图片压缩方案可以参考: https://github.com/qjoy/TinyPNGNodeJSBatcher";
    private static final Category ISSUE_CATEGORY = Category.CORRECTNESS;
    private static final int ISSUE_PRIORITY = 5;
    private static final Severity ISSUE_SEVERITY = Severity.ERROR;

    public static final Issue ISSUE = Issue.create(
            ISSUE_ID,
            ISSUE_DESCRIPTION,
            ISSUE_EXPLANATION,
            ISSUE_CATEGORY,
            ISSUE_PRIORITY,
            ISSUE_SEVERITY,
            IMPLEMENTATION
    ).addMoreInfo("https://github.com/qjoy/TinyPNGNodeJSBatcher");


    @SuppressWarnings({"WeakerAccess", "CanBeFinal"})
    String reportStr = "错误：图片文件过大: %d" + "KB,超过了项目限制的:" + CHECK_IMAGE_KB_SIZE + "KB,请进行图片压缩或找UI工程师重新设计出图.";

    private static final String CHECK_IMAGE_PNG = ".png";
    private static final String CHECK_IMAGE_JPEG = ".jpeg";
    private static final String CHECK_IMAGE_JPG = ".jpg";
    private static final long CHECK_IMAGE_KB_SIZE = 200;


    @Override
    public boolean appliesTo(ResourceFolderType var1) {
        return true;
    }

    @Override
    public void checkBinaryResource(ResourceContext context) {
        ResourceFolderType folderType = context.getResourceFolderType();
        if (folderType != null && (folderType == ResourceFolderType.MIPMAP || folderType == ResourceFolderType.DRAWABLE)) {
            String filename = context.file.getName();
            if (filename.contains(CHECK_IMAGE_PNG)
                    || filename.contains(CHECK_IMAGE_JPEG)
                    || filename.contains(CHECK_IMAGE_JPG)) {
                long fileSize = context.file.length() / 1024;
                if (fileSize > CHECK_IMAGE_KB_SIZE) {
                    String repS = String.format(reportStr, fileSize);
                    Location fileLocation = Location.create(context.file);
                    context.report(ISSUE, fileLocation, repS);
                }
            }
        }
    }
}
