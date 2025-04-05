package xyz.yeems214.kyn.Controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

public class googleOAuth2Callback {
    @GetMapping("/login/oauth2/code/google")
    public String googleOAuth2Callback(OAuth2AuthenticationToken authentication) {
        // Get the OAuth2 user details.
        OAuth2User oAuth2User = authentication.getPrincipal();

        // Get user attributes.
        Map<String, Object> attributes = oAuth2User.getAttributes();

        // Get the user's name.
        String name = (String) attributes.get("name");

        // You could also get other user attributes, like email.
        String email = (String) attributes.get("email");

        // Use the user details for your own application, like creating a user session, storing the user details in your database, etc.
        // ...

        // Redirect the user to the home page after successful login.
        return "redirect:/home";
    }
}