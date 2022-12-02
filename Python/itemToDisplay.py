def fetchItemsToDisplay(items, sortParameter, sortOrder, itemsPerPage, pageNumber):
    items.sort(key=lambda x: int(x[sortParameter]) if sortParameter > 0 else x[sortParameter], reverse=sortOrder==1)
    return [n for n,_,_ in items[pageNumber*itemsPerPage: (1+pageNumber)*itemsPerPage]]