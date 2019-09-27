package com.rvakva.xklint.rules.detector;

import com.android.tools.lint.client.api.JavaParser;
import com.android.tools.lint.client.api.UElementHandler;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.impl.source.PsiMethodImpl;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UElement;
import org.jetbrains.uast.ULiteralExpression;
import org.jetbrains.uast.UMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/**
 * @Copyright (C), 2012-2019, Sichuan Xiaoka Technology Co., Ltd.
 * @FileName: XKCustomToastDetector
 * @Author: hufeng
 * @Date: 2019/9/25 下午2:08
 * @Description:
 * @History:
 */
public class XKCustomToastDetector extends Detector implements Detector.UastScanner {


    private static final Class<? extends Detector> DETECTOR_CLASS = XKCustomToastDetector.class;
    private static final EnumSet<Scope> DETECTOR_SCOPE = Scope.JAVA_FILE_SCOPE;
    private static final Implementation IMPLEMENTATION = new Implementation(
            DETECTOR_CLASS,
            DETECTOR_SCOPE
    );

    private static final String ISSUE_ID = "XK_ToastUseError";
    private static final String ISSUE_DESCRIPTION = "警告:你应该使用我们团队自定义的Toast工具类{com.xtc.widget.phone.toast.ToastUtil}";
    private static final String ISSUE_EXPLANATION = "你不能直接使用Toast，你应该使用我们团队自定义的Toast工具类{com.xtc.widget.phone.toast.ToastUtil}";
    private static final Category ISSUE_CATEGORY = Category.CORRECTNESS;
    private static final int ISSUE_PRIORITY = 9;
    private static final Severity ISSUE_SEVERITY = Severity.WARNING;
    private static final String CHECK_CODE = "Toast";
    private static final String CHECK_PACKAGE = "android.widget.Toast";

    public static final Issue ISSUE = Issue.create(
            ISSUE_ID,
            ISSUE_DESCRIPTION,
            ISSUE_EXPLANATION,
            ISSUE_CATEGORY,
            ISSUE_PRIORITY,
            ISSUE_SEVERITY,
            IMPLEMENTATION
    );

    @Nullable
    @Override
    public List<Class<? extends UElement>> getApplicableUastTypes() {
        List<Class<? extends UElement>> types = new ArrayList<>(1);
        types.add(UMethod.class);
        return types;
    }

//    @Nullable
//    @Override
//    public UElementHandler createUastHandler(JavaContext context) {
//        return new UMethod();
//    }
    //    @Override
//    public AstVisitor createJavaVisitor(final JavaContext context) {
//        return new CusTomToastVisitor(context);
//    }
//
//    private class CusTomToastVisitor extends PsiMethodImpl {
//        private final JavaContext javaContext;
//
//        private CusTomToastVisitor(JavaContext context) {
//            javaContext = context;
//        }
//
//        @Override
//        public boolean visitMethodInvocation(MethodInvocation node) {
//
//            ResolvedNode resolve = javaContext.resolve(node);
//            if (resolve instanceof JavaParser.ResolvedMethod) {
//                JavaParser.ResolvedMethod method = (JavaParser.ResolvedMethod) resolve;
//                JavaParser.ResolvedClass containingClass = method.getContainingClass();
//                if (containingClass.matches(CHECK_PACKAGE)) {
//                    String message = ISSUE_DESCRIPTION + " ,请速度修改";
//                    javaContext.report(ISSUE, node, javaContext.getLocation(node),message);
//                    return true;
//                }
//            }
//
//            return super.visitMethodInvocation(node);
//        }
//    }
}
