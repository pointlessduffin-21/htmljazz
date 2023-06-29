# Spring Boot OAuth2 SSO with facebook
Minimal application that uses Facebook for authentication and authorization.

## Details
**Dev guide** : https://spring.io/guides/tutorials/spring-boot-oauth2/

**Client app registered with Facebook**: https://developers.facebook.com/apps/1955717241194544/dashboard/

**Security Config:**

application.yml
```
security:
  oauth2:
    client:
      clientId: 1955717241194544
      clientSecret: 24cab1f2ba38babf9dfbedbdb0c2af6b
      accessTokenUri: https://graph.facebook.com/oauth/access_token
      userAuthorizationUri: https://www.facebook.com/dialog/oauth
      tokenName: oauth_token
      authenticationScheme: query
      clientAuthenticationScheme: form
    resource:
      userInfoUri: https://graph.facebook.com/me
```
