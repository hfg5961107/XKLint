package com.rvakva.xklint.rules.detector;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UElement;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/**
 * @Copyright (C), 2012-2019, Sichuan Xiaoka Technology Co., Ltd.
 * @FileName: XKChineseStringDetector
 * @Author: hufeng
 * @Date: 2019/9/25 上午11:32
 * @Description:
 * @History:
 */
public class XKChineseStringDetector extends Detector implements Detector.UastScanner {

    private static final Class<? extends Detector> DETECTOR_CLASS = XKChineseStringDetector.class;
    private static final EnumSet<Scope> DETECTOR_SCOPE = Scope.JAVA_FILE_SCOPE;
    private static final Implementation IMPLEMENTATION = new Implementation(
            DETECTOR_CLASS,
            DETECTOR_SCOPE
    );

    private static final String ISSUE_ID = "XK_JavaChineseString";
    private static final String ISSUE_DESCRIPTION = "错误：除了Log日志打印之外，不能在java文件中使用中文字符串硬编码";
    private static final String ISSUE_EXPLANATION = "错误：除了Log日志打印之外，不能在java文件中使用中文字符串硬编码";
    private static final Category ISSUE_CATEGORY = Category.CORRECTNESS;
    private static final int ISSUE_PRIORITY = 5;
    private static final Severity ISSUE_SEVERITY = Severity.WARNING;

    public static final Issue ISSUE = Issue.create(
            ISSUE_ID,
            ISSUE_DESCRIPTION,
            ISSUE_EXPLANATION,
            ISSUE_CATEGORY,
            ISSUE_PRIORITY,
            ISSUE_SEVERITY,
            IMPLEMENTATION
    );


    private static final String LOG_CLASS = "android.util.Log";
    private static final String LOGUTIL_CLASS = "com.xtc.log.LogUtil";

//    @Nullable
//    @Override
//    public List<Class<? extends UElement>> getApplicableUastTypes() {
//        return Collections.<Class<? extends UElement>>singletonList(StringLiteral.class);
//    }


    //    @Override
//    public boolean appliesTo(@NonNull Context context, @NonNull File file) {
//        return true;
//    }
//
//    @NonNull
//    @Override
//    public Speed getSpeed() {
//        return Speed.FAST;
//    }
//
//    @Override
//    public List<Class<? extends Node>> getApplicableNodeTypes() {
//        return Collections.<Class<? extends Node>>singletonList(StringLiteral.class);
//    }
//
//    @Override
//    public AstVisitor createJavaVisitor(@NonNull JavaContext context) {
//        return new XTCChineseStringDetector.StringChecker(context);
//    }
//
//    private static class StringChecker extends ForwardingAstVisitor {
//        private final JavaContext mContext;
//
//        public StringChecker(JavaContext context) {
//            mContext = context;
//        }
//
//        @Override
//        public boolean visitStringLiteral(StringLiteral stringLiteral) {
//            String astValue = stringLiteral.astValue();
//            if (astValue.isEmpty()) {
//                return false;
//            }
//            String patternStr = "[\\u4e00-\\u9fa5]";
//            Pattern pattern = Pattern.compile(patternStr);
//            Matcher matcher = pattern.matcher(astValue);
//            //匹配到了中文字符
//            if (matcher.find()) {
//                Node node = stringLiteral.getParent();
//                JavaParser.ResolvedNode resolve =  mContext.resolve(node);
////                System.out.println("=======================出现中文：" + astValue + " ,resolve = " + resolve);
//                if (resolve == null){
////                    System.out.println("=======================出现中文：" + astValue + " ,resolve == null,现在进入循环判断");
//                    while (resolve == null){
//                        node = node.getParent();
//                        resolve =  mContext.resolve(node);
////                        System.out.println("=======================出现中文：" + astValue + " ,循环判断中,resolve = " + resolve);
//                        if (resolve != null) {
//                            checkIfInLogPrint(stringLiteral, astValue, (JavaParser.ResolvedMethod) resolve);
//                            break;
//                        }
//                    }
//                }else {
//                    checkIfInLogPrint(stringLiteral, astValue, (JavaParser.ResolvedMethod) resolve);
//                }
//            }
//            return false;
//        }
//
//        /**
//         * 判断是否处于Log打印中的中文
//         * @param stringLiteral
//         * @param astValue
//         * @param resolve
//         */
//        private void checkIfInLogPrint(StringLiteral stringLiteral, String astValue, JavaParser.ResolvedMethod resolve) {
//            JavaParser.ResolvedMethod method = resolve;
//            JavaParser.ResolvedClass containingClass = method.getContainingClass();
////            System.out.println("=======================出现中文======================= ， containingClass = " + containingClass.getName());
//
//            //如果是Log或者LogUtil打印日志里面出现中文的话
//            if (containingClass.matches(LOG_CLASS)
//                    || containingClass.matches(LOGUTIL_CLASS)) {
////                System.out.println("Log或者LogUtil打印日志,出现中文不报告");
//            } else{
//                mContext.report(ISSUE, stringLiteral, mContext.getLocation(stringLiteral),
//                        "不能在java文件中使用中文字符串硬编码,检测出来的字符串为:{  " + astValue + "  }");
//            }
//        }
//    }
}
