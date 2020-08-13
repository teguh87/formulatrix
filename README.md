# formulatrix

# Introduction
This project based on requirement for hiring test provided by Formulatrix. 
It consist of storing the item content from registration data. 
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
  <pre>
    maven clean install
  </pre>

- run the spring module 
  <pre>mvn spring-boot:run</pre>

# Api doc and sample project
## Sample the project

<pre>
 - example no 1
    -- item content : &lt;register&gt;&lt;firstname&gt;Nemo&lt;firstname&gt;&lt;lastname&gt;NoBody&lt;lastname&gt;&lt;email&gt;nemo@example.com&lt;email&gt;&lt;password&gt;123456&lt;password&gt;&lt;phoneNumber&gt;+628177728172&lt;phoneNumber&gt;&lt;address&gt;Anywhere&lt;address&gt;&lt;register
    -- item name: annon1
    -- item type: 2
 - example no 2
    -- item content : &lt;register&gt;&lt;firstname&gt;Setyo&lt;firstname&gt;&lt;lastname&gt;Nugroho&lt;lastname&gt;&lt;email&gt;setyo@example.com&lt;email&gt;&lt;password&gt;123456&lt;password&gt;&lt;phoneNumber&gt;+62883881777&lt;phoneNumber&gt;&lt;address&gt;Anywhere&lt;address&gt;&lt;register&gt;
    -- item name: annon2
    -- item type 2
 -  example no 3
    -- item content : {\"firstname\":\"Aprilia\",\"lastname\":\"Sadewa\",\"email\":\"aprillia@example.com\",\"password\":\"123456\",\"phoneNumber\":\"+6281772663773\",\"address\":\"Anywhere\"}
    -- item name: annon 3
    -- item type : 3
</pre>

## using curl for request the api
<pre>
 curl -d "itemName=annon1&itemType=2&itemContent=&lt;register&gt;&lt;firstname&gt;Nemo&lt;firstname&gt;&lt;lastname&gt;NoBody&lt;lastname&gt;&lt;email&gt;nemo@example.com&lt;email&gt;&lt;password&gt;123456&lt;password&gt;&lt;phoneNumber&gt;+628177728172&lt;phoneNumber&gt;&lt;address&gt;Anywhere&lt;address&gt;&lt;register -H "Content-Type: application/x-www-form-urlencoded" -X POST http://localhost:8080/register
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