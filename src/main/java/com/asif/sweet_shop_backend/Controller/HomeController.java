package com.asif.sweet_shop_backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<html><body style='font-family: sans-serif; padding: 20px;'>" +
                "<h1>Sweet Shop Backend API</h1>" +
                "<p>Status: <span style='color: green;'>Running</span></p>" +

                "<h2>Authentication</h2>" +
                "<table border='1' cellpadding='10' style='border-collapse: collapse;'>" +
                "<tr><th>Method</th><th>Endpoint</th><th>Description</th><th>Auth</th></tr>" +
                "<tr><td>POST</td><td>/api/auth/register</td><td>Register new user</td><td>No</td></tr>" +
                "<tr><td>POST</td><td>/api/auth/login</td><td>Login and get JWT token</td><td>No</td></tr>" +
                "</table>" +

                "<h2>Sweets Management</h2>" +
                "<table border='1' cellpadding='10' style='border-collapse: collapse;'>" +
                "<tr><th>Method</th><th>Endpoint</th><th>Description</th><th>Auth</th></tr>" +
                "<tr><td>GET</td><td>/api/sweets</td><td>Get all sweets</td><td>Yes</td></tr>" +
                "<tr><td>GET</td><td>/api/sweets/{id}</td><td>Get sweet by ID</td><td>Yes</td></tr>" +
                "<tr><td>POST</td><td>/api/sweets</td><td>Create new sweet</td><td>Yes</td></tr>" +
                "<tr><td>PUT</td><td>/api/sweets/{id}</td><td>Update sweet</td><td>Yes</td></tr>" +
                "<tr><td>DELETE</td><td>/api/sweets/{id}</td><td>Delete sweet</td><td>Yes</td></tr>" +
                "</table>" +
                "</body></html>";
    }
}
