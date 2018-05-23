Conventions
===========

List of accepted internal conventions on the mlearn project.

URI,URN and URL use
-------------------

For any created URI value on the mlearning project, there must be a mechanism of to 
find and retrieve the object/data independent of the mlearning logic and infrastructure.

This implies that URI values created under the https schema, must be available on internet.

A URN value will identify a object, but the retrieval mechanism will be internal to the mlearn project.

It means, that a reference to "urn:mlearn-user:userID123123" will not be available on internet, but on
mlearning internal infrastructure there will be services to retrieve such value. 

Relevant RFCs:

- URI: https://tools.ietf.org/html/rfc3986
- W3 info: https://tools.ietf.org/html/rfc3305
- URN: https://tools.ietf.org/html/rfc8141


