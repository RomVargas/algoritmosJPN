def minimumWaitingTime(queries):
    """
    We sort the list of queries, and then for each query, we multiply the duration of the query by the
    number of queries left in the list
    
    :param queries: an array of integers representing the duration of each query
    :return: The total waiting time for all the queries.
    """
    queries.sort()
    totalWaitingTime = 0
    for idx, duration in enumerate(queries):
        queriesLeft = len(queries) - (idx + 1)
        totalWaitingTime += duration * queriesLeft 
    return totalWaitingTime