# midi.soundfont

A library for loading MIDI soundfonts into the JVM, and making it quick and easy to get nice sounds out of your MIDI system. :notes:

Quality soundfonts can get pretty big (FluidR3 is ~141 MB), so instead of packaging them all here, each soundfont (or maybe collection of soundfonts, if they're small ones) should be its own separate jar, and this library can pull them down from clojars *à la carte*.\*

> *Work in progress. Apparently accessing resources from another project is really complicated!
