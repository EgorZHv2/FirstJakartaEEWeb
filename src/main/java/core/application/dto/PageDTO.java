package core.application.dto;

import java.util.List;

public class PageDTO<T> {


    private int pageNumber;
    private int maxPages;
    private   int itemsOnPage;
    private int maxItems;
    private List<T> items;
    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public int getMaxPages() {
        return maxPages;
    }
    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }
    public int getItemsOnPage() {
        return itemsOnPage;
    }
    public void setItemsOnPage(int itemsOnPage) {
        this.itemsOnPage = itemsOnPage;
    }
    public int getMaxItems() {
        return maxItems;
    }
    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }
    public List<T> getItems() {
        return items;
    }
    public void setItems(List<T> items) {
        this.items = items;
    }
    public PageDTO(PaginationDTO dto,List<T> items,Integer itemsCount){
        this.setItems(items);
        this.setMaxItems(itemsCount);
        this.setMaxPages((int) Math.ceil((double)itemsCount/(double) dto.getPageSize()));
        this.setItemsOnPage(dto.getPageSize());
        this.setPageNumber(dto.getPageNumber());
    }
}
