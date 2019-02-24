Last year I started to get slightly interested on GraphQL. A new way of creating Web APIs. I have read a couple of books (though I need to re-read them now that I have some actual coding experience). I have seen quite a few presentations. And one of the reasons I decided to have my own is because I saw people bashing REST as a way to introduce GraphiQL. There is no need. GraphiQL can stand on its own two (or three, or four) feet.

Let's establish a base of how I think. Please raise your hands if you have done any REST api. Now take them down if you have used Swagger, Apiary, ReDoc or any other documentation tool of the same type. Now, of the remaining ones, keep your hands up if you were returning hypermedia links on the return data (your own format or using things like json-hal). Congratulations, you are the ones that are doing REST. For the others, you are not.

One of the most infuriating things, and is not exclusive to our profession, is that we misuse terms. You have heavy processes from which the dev can't deviate, don't call that Agile. Same with REST. Of course, some luminarie came with Restful or Restish to indicate something that isn't REST but you still have the use of the cool term.

How many have read the original Fielding disertation? It is illuminating. Fielding defines there REST as an Architectural Style with certains characteristics. One of them, is that returned data should point you to what you can do next. Another, is that HTTP is both a REST architecture and a design implementation. Which is my issue with Swagger and the like. They make fixed URLs the center of your API. Nothing at all like REST.

What about REST in Practice, by Webber. Parastatidis and Robinson? The first time reading that one didn't click (as I was reading it because I was going to work on my first (finger quotes) REST api. But on the second reading, it did. REST is superb to describe business processes. Which is exactly the example that they use to drive the book.

But, and a big but here, most APIs that you see out there are light in business processes. Which is the issue that Facebook realized they had. They needed something specifically designed for data.

So we reach that point point in which we have a clear separation between REST and GraphQL. The former is about processes, the later is about data.

There is another big difference, really massive: REST is an architectural style, and that means that there is no implementation of it. Every time you want to create a new REST api you need to satar from scratch. 
