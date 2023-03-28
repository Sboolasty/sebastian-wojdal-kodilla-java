package com.example.kodillapatterns.strategy;

sealed class User (String userName)
    permits Millenials, YGeneration, ZGeneration {
        private SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
    }

        public void setSocialPublisher (SocialPublisher socialPublisher){
        this.socialPublisher = socialPublisher;
    }

        public String sharePost () {
        socialPublisher.share();
        return null;
    }
    }

