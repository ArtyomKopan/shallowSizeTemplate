# An Kotlin compiler plugin

A small Kotlin compiler plugin to calculate the sum of sized of 
the properties in data classes powered by [arrow-meta](https://github.com/arrow-kt/arrow-meta).


**Note**: Intellij Idea highlight shallowSize method in tests as an error, it is ok since the Kotlin compiler API with the old front-end requires implementing an additional Intellij Idea plugin to fix it. Just run tests and it will works correctly
