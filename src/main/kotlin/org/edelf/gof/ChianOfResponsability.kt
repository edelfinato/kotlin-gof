package org.edelf.gof

sealed class File(val content:String){
    class TextFile(content: String) : File(content)
    class AudioFile(content: String) : File(content)
    class VideoFile(content: String) : File(content)
    class PresetationFile(content: String) : File(content)

    override fun toString(): String {
        return this.javaClass.simpleName + "(content='$content')"
    }
}

fun parseText(file:File?): String? {
    if (file is File.TextFile){
        return file.content
    }
    return null
}


fun parseAudio(file:File?): String? {
    if (file is File.AudioFile){
        return file.content
    }
    return null
}


fun parseVideo(file:File?): String? {
    if (file is File.VideoFile){
        return file.content
    }
    return null
}


fun parsePresentation(file:File?): String? {
    if (file is File.PresetationFile){
        return file.content
    }
    return null
}

val funs = listOf(::parseAudio, ::parsePresentation, ::parseText, ::parseVideo)
