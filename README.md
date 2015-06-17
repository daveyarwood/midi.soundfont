# midi.soundfont

A library for loading MIDI soundfonts into the JVM, and making it quick and easy to get nice sounds out of your MIDI system. :notes:

I'm still trying to figure out a good way to package soundfonts as individual dependencies. Quality soundfonts can get pretty big (FluidR3 is 141 MB), so my first thought was to package them individually as clojars, so that they can be pulled down in isolation by the programs that need them, and then loaded into the JVM using this library. Unfortunately, clojars has a 20 MB limit on clojar size. 

The alternative is deploying to Maven Central, which is apparently about as easy as applying for a mortgage. I would be very interested to know if there is a simpler solution to this problem. 

In the meantime, I suppose the easiest thing to do is to skip package management and just have your programs download the soundfonts from the internet, maybe even from a Bitbucket repo or something (of note, Bitbucket allows repos up to 2 GB in size -- that's plenty big enough for most soundfonts).
