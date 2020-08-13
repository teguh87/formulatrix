# formulatrix

# Introduction
This project based on requirement for hiring test provided by Formulatrix 
it consist of storing the item content from registration data. 
We will build Rest APIs by helping of storing item content of registration data. 
Every configuration will be Java based Annotations instead XML and JSON.

We will try to cover all registration problems and their solutions as much as we can do.


# How to run
## Requirement
- Need Java JDK Minimun reqirement JDK 8
- Need Install maven repository manager
- Need Git to clone the source project

## Run the source project
- Clone this repository
  <pre>
    git clone https://github.com/teguh87/formulatrix.git
  </pre>

- Install dependancies using maven
 <pre>maven clean install</pre>

- run the spring module 
  <pre>mvn spring-boot:run</pre>

# Api doc and sample project
## Sample the project

<pre>
 - example no 1
    -- item content : <register><firstname>Nemo</firstname><lastname>NoBody</lastname><email>nemo@example.com</email><password>123456</password><phoneNumber>+628177728172</phoneNumber><address>Anywhere</address></register>
    -- item name: annon1
    -- item type: 2
 - example no 2
    -- item content : <register><firstname>Setyo</firstname><lastname>Nugroho</lastname><email>setyo@example.com</email><password>123456</password><phoneNumber>+62883881777</phoneNumber><address>Anywhere</address></register>
    -- item name: annon2
    -- item type 2
 -  example no 3
    -- item content : {\"firstname\":\"Aprilia\",\"lastname\":\"Sadewa\",\"email\":\"aprillia@example.com\",\"password\":\"123456\",\"phoneNumber\":\"+6281772663773\",\"address\":\"Anywhere\"}
    -- item name: annon 3
    -- item type : 3
</pre>

## using curl for request the api
<pre>
 curl -d "itemName=annon1&itemType=2&itemContent= <register><firstname>Nemo</firstname><lastname>NoBody</lastname><email>nemo@example.com</email><password>123456</password><phoneNumber>+628177728172</phoneNumber><address>Anywhere</address></register>" -H "Content-Type: application/x-www-form-urlencoded" -X POST http://localhost:8080/register
</pre>

## Open API
### Register
<pre>
  POST http://localhost:8080/register
</pre>

### Retrival
<pre>
 GET http://localhost:8080/register/retrival/{itemName}
</pre>

### Get Item Type
<pre>
 GET http://localhost:8080/register/itemType/{itemName}
</pre>

### Get Unregister
<pre>
 DELETE http://localhost:8080/register/unregister/{itemName}
</pre>