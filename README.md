# Postr Application

There is an social media application that can post a text information to internet anonymously and let the community engage that post, we will call it Postr

# Database and table setup

```agsl
CREATE DATABASE postr_db;
```
```agsl
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `active` int DEFAULT NULL,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `roles` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
```
```agsl
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `post` text NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ky67sgi7k0ayf22652f7763r` (`user_id`),
  CONSTRAINT `FK7ky67sgi7k0ayf22652f7763r` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
```
```agsl
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `comment` text NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`),
  CONSTRAINT `FKs1slvnkuemjsq2kj4h3vhx7i1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
```


# How to run?

1. `mvn clean install`
2. `mvn spring-boot:run`
3. using postman or others tools, open : `http://localhost:8088/hello-world`

# API documentation

### Creating new Post
URL : `{{BASE_URL}}/posts`

Method : POST
Payload : 
```json
{
    "userId" : 3,
    "post" :"Posting lagi...",
    "createdAt" : "2023-08-18T15:47:10.162+00:00",
    "updatedAt" : "2023-08-18T15:47:10.162+00:00"
}
```
Response :
```json
{
    "id": 10,
    "userId": 3,
    "post": "Posting lagi...",
    "createdAt": "2023-08-18T15:47:10.162+00:00",
    "updatedAt": "2023-08-18T15:47:10.162+00:00",
    "comments": null,
    "user": null
}
```

### Get All Post (with infinite scroll pagination support)
URL : `{{BASE_URL}}/posts?page=1&offset=1`

Method : GET

Param Query : `page` (int) and `offset` (int)

Response : 
```json
{
    "total": 1,
    "offset": 1,
    "has_previous": true,
    "page": 1,
    "posts": [
        {
            "id": 2,
            "userId": 3,
            "post": "post pertama",
            "createdAt": "2023-08-16T17:00:00.000+00:00",
            "updatedAt": "2023-08-16T17:00:00.000+00:00",
            "comments": [
                {
                    "id": 2,
                    "postId": 2,
                    "userId": 3,
                    "comment": "Komen 1",
                    "createdAt": "2023-08-16T17:00:00.000+00:00",
                    "updatedAt": "2023-08-16T17:00:00.000+00:00"
                },
                {
                    "id": 3,
                    "postId": 2,
                    "userId": 3,
                    "comment": "Komen 2",
                    "createdAt": null,
                    "updatedAt": "2023-08-16T17:00:00.000+00:00"
                }
            ],
            "user": {
                "id": 3,
                "username": "ab@postr.com",
                "password": "123456789",
                "roles": "admin",
                "post": null
            }
        }
    ]
}
```

### Create new Comment
URL : `{{BASE_url}}/comments`

Method : POST

Payload : 
```json
{
    "postId" : "1",
    "userId" : "2",
    "comment" : "Komentar pertama lagi",
    "createdAt" : "2023-08-18T15:47:10.162+00:00",
    "updatedAt" : "2023-08-18T15:47:10.162+00:00"
}
```

Response : 
```json
{
    "id": 12,
    "postId": 1,
    "userId": 2,
    "comment": "Komentar pertama lagi",
    "createdAt": "2023-08-18T15:47:10.162+00:00",
    "updatedAt": "2023-08-18T15:47:10.162+00:00"
}
```

## Run Unit Test 

```agsl
mvn exec:java -Dexec.mainClass="com.angga.postr.api.PostrAppTest" -Dexec.classpathScope=test
```
