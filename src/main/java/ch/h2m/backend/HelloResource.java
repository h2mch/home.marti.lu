package ch.h2m.backend;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("hello")
public class HelloResource {

    @Inject
    HelloService helloService;

    @GET
    @Path("text")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@QueryParam("name") String name) {
        return Templates.text(name).render();
    }

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(helloService.get()).build();
    }

    @GET
    @Path("form")
    @Produces(MediaType.TEXT_HTML)
    public String getHTML() {
        return Templates.form(helloService.get()).render();
    }

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance text(String name);
        public static native TemplateInstance form(Hello hello);
    }


}
