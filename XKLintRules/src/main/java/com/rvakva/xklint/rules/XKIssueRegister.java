package com.rvakva.xklint.rules;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.ApiKt;
import com.android.tools.lint.detector.api.Issue;
import com.rvakva.xklint.rules.detector.LogDetector;
import com.rvakva.xklint.rules.detector.ThreadDetector;
import com.rvakva.xklint.rules.detector.XKHardcodedValuesDetector;
import com.rvakva.xklint.rules.detector.XKImageFileSizeDetector;
import com.rvakva.xklint.rules.detector.XKViewIdNameDetector;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Copyright (C), 2012-2019, Sichuan Xiaoka Technology Co., Ltd.
 * @FileName: XKIssueRegister
 * @Author: hufeng
 * @Date: 2019/9/25 上午10:54
 * @Description:
 * @History:
 */
public class XKIssueRegister extends IssueRegistry {
    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                LogDetector.ISSUE,
                ThreadDetector.ISSUE,
                XKHardcodedValuesDetector.ISSUE,
                XKImageFileSizeDetector.ISSUE,
                XKViewIdNameDetector.ISSUE
        );
    }

    @Override
    public int getApi() {
        return ApiKt.CURRENT_API;
    }
}
