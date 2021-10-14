package com.example.parsexmlusingretrofit

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "entry", strict = false)
class Entry @JvmOverloads constructor(

    @field:Element(name = "content")
    @param:Element(name = "content")
    var content: String? = null,

    @field:Element(name = "author")
    @param:Element(name = "author")
    var author: Author? = null,

    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,

    @field:Element(name = "id")
    @param:Element(name = "id")
    var id: String? = null,

    @field:Element(name = "updated")
    @param:Element(name = "updated")
    var updated: String? = null,

    @field:Element(name = "published")
    @param:Element(name = "published")
    var published: String? = null

) : Serializable {}

@Root(name = "author", strict = false)
class Author constructor(): Serializable {

    @field:Element(name = "name")
    var name: String? = null

    @field:Element(name = "uri")
    var uri: String? = null

    override fun toString(): String {
        return "Author{name=\"$name\", uri=\"$uri\"}}"
    }

}