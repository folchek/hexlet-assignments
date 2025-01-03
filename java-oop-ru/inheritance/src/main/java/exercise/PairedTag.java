package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> childrenTags;

    public PairedTag(String tagName, Map<String, String> tagAttributes,
                     String tagBody, List<Tag> childrenTags) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childrenTags = childrenTags;
    }

    public String childrenTagsOneLine() {
        return childrenTags.stream()
                .map(object -> object.toString())
                .collect(Collectors.joining(""));
    }

    @Override
    public String toString() {
        return String.format("%s%s</%s>",
                super.toString(),
                tagBody + childrenTagsOneLine(),
                super.getTagName()
        );
    }
}
// END
