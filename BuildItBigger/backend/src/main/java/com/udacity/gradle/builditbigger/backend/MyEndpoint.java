package com.udacity.gradle.builditbigger.backend;

import com.example.android.sillyjokes.Jokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * This Method uses java class "Jokes" from Java library "sillyJokes" to return a joke.
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi() {
        MyBean response = new MyBean();
        response.setData(new Jokes().getJoke());
        return response;
    }
}
