package com.google.common.eventbus;

public class RegPromotionObserver {
    // 依赖注入
    private PromotionService promotionService;

    @Subscribe
    public void handleRegSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
