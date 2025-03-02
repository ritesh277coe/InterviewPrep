Youtube: https://www.youtube.com/watch?v=AXZkhKTbbWc

### 
Spring boot make it easy to create Spring based application that are production grade and can run. 

Spring was mainly for dependency inversion/IOC, but now it has all sort of support for almost everything that
programmer needs. That is what it makes it hard to configure Spring application to match the needs to programmer.

SpringBoot gives a quick to start a complex spring based application which used common conventional wisdom over custom configuration.
After this user is free to alter configuration for custom scenario

Most common annotation for spring based application:

### @Component:
    When class is annotated with @Component, it tells Spring IOC container to create bean for the class and manage the lifecycle of the bean.
    {
        @Service: Belongs to service layer that implements business logic
        @Controller: Web request handler
        @Repository: Class that interact with DB and performs DB crud operation
    }

### @Autowired:
    Can be applied on constructor/field/setter method
    @Primary on class
    @Qualifier on top of the dependency
    
    When enabling dependency injection, if bean initializer get confused, then we can use @Primary on the class level 
    so that that class becomes primary candidate in case of confusion, or we can use @Qualifier("nameofthebean") so that
    autowire know which bean to call to resolve dependency

### @Value:
    Helps in injecting external properties (Property file) into your bean.
    Can be use when class is Component/Service/Controller/Repository bean.
    @Value("Testvalue")   ///Assigns default value to the variable
    String val;   
    @Value(${mail.host})  //application.properties file will be read and value will be assigned to mailHost
    String mailHost; 
    @Value(${HOME}) //will read environment

### @PropertySource / @PropertySources
    By default, application is looked for values, but if application wants different sources
    then
    @PropertySources({
        @PropertySource("a.properties")
        @PropertySource("b.properties")
    })


### @ComponentScan:

### @Configuration:
    Does not implement business logic rather implements code for setup/initialization of application.
    

### @Bean
    create a spring bean by calling a function that enable user to provide N args to instantiate
    an object and then add into spring as bean.

    So Ex:
        @Configuration
        public class MyConf {
            @Bean
            MyCustomObject createCustomObject(Arg...args) {
                ...
                return new MyCustomObject(args);
            }
        }
        So Using above way to instantiate spring beans is an alternative way to create way, and pretty
        much we stop all above ways to create objects that are created using
        Component/Repository/Service/Controller
        All these above mentioned creates Beans using TYPE, but @Bean lets user create a bean using function signature
        @Bean("Qualifier" = "beanname", "initMethod" = "init", "destroyMethod" = "destroy") So bean can access with 
        name "beanname", and after bean creation, init method will be called. Best usecase is when bean uses db connections,
        So init can make db connection and destroy can delete db connection.

@Transactional:
    //Need example
    Provide method

@RequestMapping: Helps in routing web requests
    @Controller
    @RequestMapping("/orders")
    public class OrderController {
        @GetMapping             //PutMapping/PostMapping/DeleteMapping
        Orders getOrders();

        @GetMapping("/{id}")
        Orders getOrders(@PathVariable int id){};
    }

//******//
Below example of Post Mapping + @RequestBody for post data + @RequestParam("key") + @PathVariable
@PostMapping("/person", consumes =  MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(value = HttpStatus.CREATED)
public ResponseEntity<Person> zello(@RequestBody Person p) {
	return new ResponseEntity<>(p, HttpStatus.CREATED);
}

@GetMapping("/json/{str1}/{str2}")
public GreetResponse sendJson(@PathVariable("str1") String s1, @PathVariable("str2") String s2) {
	return new GreetResponse(s1+s2, new Person("Ritesh", 42));
}


@GetMapping("/custom", produces = MediaType.APPLICATION_JSON_VALUE)
public String zello(@RequestParam("k") String k, @RequestParam("v")String v) {
	return k+v;
}

@SpringBootApplication
    Put it on main all code becomes spring beans
    It is a combination as 
    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan

@Controller For implementing Rest elated mapping
@Service: For implementing service logic
@Repository: For implementing DAO
    StereoType annotation derived from Componenet
    Best for rest api classes

@Lazy
    Create bean when needed. Its bad as any issues are obsured and are furnished during runtime
    Can be used with @Bean or @Component or @Configuration

@Scope ("value"="prototype")
    Singleton/Prototype/request/session/websocket/application
    Default scope is singleton
