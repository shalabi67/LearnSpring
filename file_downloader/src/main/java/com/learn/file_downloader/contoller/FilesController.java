package com.learn.file_downloader.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;



import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;


@RestController
public class FilesController {
    @Autowired
    private ServletContext servletContext;

    /*
    @RequestMapping(value="/images", method= RequestMethod.GET)
    @Produces("image/png")
    public Response getFile() {

        File file = new File("aa/1.png");

        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename=image_from_server.png");
        return response.build();

    }
    */

    @RequestMapping(value = "/images2", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageAsResponseEntity() throws IOException {
        ResponseEntity<byte[]> responseEntity;
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        final InputStream in = new ClassPathResource("1.png").getInputStream();
        byte[] media = IOUtils.toByteArray(in);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;
    }

    /*
    @RequestMapping(value="/images", method= RequestMethod.GET)
    public ResponseEntity<Resource> getFile() throws IOException {
        final HttpHeaders headers = new HttpHeaders();
        String path = new ClassPathResource("/error/1.html").getURI().getPath();
        Resource resource = new ServletContextResource(servletContext, path);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
    */

}
