package advertisement.config.service;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchDTO {
    private Long searchTerm;

    private SearchType searchType;

    public SearchDTO() {}

    public Long getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(Long searchTerm) {
        this.searchTerm = searchTerm;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
