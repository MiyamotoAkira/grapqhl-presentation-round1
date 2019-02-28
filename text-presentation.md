Hello Everyone.

My name is Jorge Gueorguiev Garcia. And I work at a Technical Consultancy called Codurance. My emails are :jorge.gueorguiev@codurance.com and yefo.akira@gmail.com My twitter account is @yefoakira

**Create project**

Last year I started to get slightly interested on GraphQL. A new way of creating Web APIs. I read a couple of books (though I need to re-read them now that I have some actual coding experience). I saw quite a few presentations. And one of the reasons I decided to have my own is because,between other things, I saw people bashing REST as a way to introduce GraphQL. Typical to bash something previous when introducing something new. There is no need. GraphQL can stand on its own two feet. And I wanted to demonstrate the most impressive capability.

**copy resources and show data**

Let's establish a base of how *I* think. Please raise your hands if you have done any REST api. Now take them down if you have used Swagger, Apiary, ReDoc or any other documentation tool of the same type. Now, of the remaining ones, keep your hands up if you were returning hypermedia links on the return data (your own format or using things like json-hal). Congratulations, you are the ones that are doing REST. For the others, you are not.

**start repl and change project.clj**

One of the most infuriating things, and is not exclusive to our profession, is the same for all humanity. Is that we misuse terms. "We are doing Agile". Wait, you have heavy processes from which the dev can't deviate, don't call that Agile. It isn't. Same with REST, if you are ignoring what makes REST REST, then you can't call it REST. Of course, some luminarie came with Restful and Restish to indicate something that isn't REST but you still have the use of the cool term (well, back then, not anymore).

**Copy schema.edn**

How many have read the original Fielding disertation? It is illuminating. Fielding defines there REST as an Architectural Style with certains characteristics. One of them, is that returned data should point you to what you can do next. HATEOAS Hypermedia as the engine of application state.  Which is my issue with Swagger and the like. They make fixed URLs the center of your API. Nothing at all like REST. In REST the return data tells you what is available!!.

**Copy schema.clj**

What about REST in Practice, by Webber, Parastatidis and Robinson? The first time reading that one didn't click (as I was reading it because I was going to work on my first (finger quotes) REST api) But on the second reading, it did. REST is superb to describe business processes. Which is exactly the example that they use to drive the book. Is the businness process of a coffe shop. Incidentally you have data, but the process is the thing that you are modeling.

**Copy schema.clj**

But, and a big but here, most APIs that you see out there are light in business processes. Which is the issue that Facebook realized they had. They needed something specifically designed for data.

**Copy schema.clj**

So we reach that point in which we have a clear separation between REST and GraphQL. The former is about processes, the later is about data.
**Copy schema.clj**

There is another big difference, really massive: REST is an architectural style, and that means that there is no implementation of it. Every time you want to create a new REST api you need to start from scratch. You have to define how your API is going to behave, what is available, what are the links that you can use. How do you searches, how do you modify, what http verb you want to use, how do you define the links? You have to create a client from scratch each time. Even if you reuse some libraries there is so much work to do. Which makes sense: Architectural Style. Thefore I have to define the architecture and implementation.

**modify service.clj and server.clj**

GraphQL on the other hand is a fixed architecture. Things should work in a very specific way. You don't have to define it. The elements are exactly the same on all GraphQL apis. You have a schema that follows a very specific format. You always need resolvers. You always use the single POST request for everything. And the client is the same, doesn't matter how many apis you make: the difference is the information that is passed in the post, and the information that you retrieve; But the format of both is exactly the same.

Let's gonna see quickly what the running api does

**run api**

Let's gonna get all current users, just asking for the id. Now for the username. Let's add books. And now only books that have id 2

And this, this is what makes GraphQL awesome. I  have search capabilities, and some filtering, and can decide what data will come back. All in a few lines of code done in a few minutes (the original sitting on which I wrote the code that I just copy pasted was 20 minutes).
