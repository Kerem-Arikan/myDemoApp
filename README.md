[![Build Status](https://travis-ci.com/Kerem-Arikan/myDemoApp.svg?branch=main)](https://travis-ci.com/Kerem-Arikan/myDemoApp)

Demo site: https://serene-river-50151.herokuapp.com/compute

This algorithm decides the prefixes of a string array (left text area). All prefixes will be written to
the text area in the middle. The text area on the right will contain a single integer value which signi-
fies the length of a prefix.

The algorithm utilizes a trie structure where each character adds a new branch to the trie. When parsed,
full strings are compared to the different paths of the trie. If present, there is a prefix, otherwise 
a warning string is returned.