# spring-boot-mongodb
This repository contains a Spring Boot example project for MongoDB.

For a code review of this repo, see my related [blog post](https://springframework.guru/3402-2/).

You can learn more about my courses [here](http://courses.springframework.guru/courses/) on my site.

##docker commands to run mongo image
### run mongo docker command
docker run -p 27017:27017 -v /home/mohammad/temp/mongo:/data/db -d mongo

### see mongo logs
docker logs -f imageName


### stop mongo
docker stop imageName

