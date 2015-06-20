# midi.soundfont

A library for loading MIDI soundfonts into the JVM, and making it quick and easy to get nice sounds out of your MIDI system. :notes:

## Example: FluidR3

FluidR3 is one of the most commonly used freeware General MIDI soundfonts. I've packaged it as a Maven dependency, with the .sf2 file itself as a resource and a namespaced var `midi.soundfont.fluid-r3/sf2` included in order to provide an easy way to access the soundfont from a separate Clojure project. 
The source code for this package is [here](https://bitbucket.org/daveyarwood/midi.soundfont.fluid-r3/src) -- it's a good example, if you're interested in packaging a soundfont yourself.

To load the instruments from this soundfont into your JVM, first add the following to your dependencies:

    [midi.soundfont "0.1.0"]
    [org.bitbucket.daveyarwood/fluid-r3 "0.1.1"]

Then you can do something like this:

    (require '[midi.soundfont :refer (load-all-instruments! midi-test load-patch)]
             '[midi.soundfont.fluid-r3 :as fluid-r3])

    (import '(javax.sound.midi MidiSystem))

    (def synth (MidiSystem/getSynthesizer))
    (load-all-instruments! synth fluid-r3/sf2)

    (midi-test synth) ; you should hear a nice-sounding piano
    
    (load-patch synth 30)
    (midi-test synth) ; you should hear a gnarly distorted guitar!

## Packaging soundfonts

Quality soundfonts can get pretty big -- FluidR3 is 141 MB. Unfortunately, Clojars has a 20 MB limit on package size, thus making it unsuitable for packaging any soundfonts larger than 20 MB. GitHub also places a strict limit of 100 MB for each file in a repo, and a total repo size limit of 1 GB. 

I was able to package FluidR3 by hosting the repo on Bitbucket -- they have a 2 GB total repo size limit, and no limits on individual file size -- and deploying the package to Maven Central. Deploying to Maven Central is a fairly complicated, but doable (if not somewhat painful) process. You can read more about it [here](https://github.com/technomancy/leiningen/blob/master/doc/DEPLOY.md).
