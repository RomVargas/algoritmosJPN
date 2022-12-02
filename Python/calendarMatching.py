def calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration):
    """
    We're taking two calendars, each with their own daily bounds, and merging them together into one
    calendar. Then, we're flattening that calendar so that all the free time slots are sorted and
    consecutive (e.g. if we have two free time slots [0, 15] and [30, 45] in the calendar, they get
    merged into one time slot [0, 45]). Then, we're returning all the time slots from the flattened
    calendar that are long enough to fit a meeting of the given duration
    
    :param calendar1: [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]]
    :param dailyBounds1: [["9:00", "20:00"]]
    :param calendar2: [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]]
    :param dailyBounds2: [["9:00", "20:00"]]
    :param meetingDuration: 30 (minutes)
    :return: A list of tuples of start and end times that are available for both calendars.
    """
    updatedCalendar1 = updateCalendar(calendar1, dailyBounds1)
    updatedCalendar2 = updateCalendar(calendar2, dailyBounds2)
    mergedCalendar = mergeCalendar(updatedCalendar1, updatedCalendar2)
    flattenedCalendar = flattenCalendar(mergedCalendar)
    return getMatchingAvailabilities(flattenedCalendar,meetingDuration)


def updateCalendar(calendar, dailyBounds):
    """
    It takes two calendars and a meeting duration, and returns a list of all the times in the day when
    both people are available for a meeting of the specified duration
    
    :param calendar: a list of lists. Each element of the list represents a meeting time range. The
    first element of the meeting time range is the start time, and the second element is the end time.
    The start time and the end time are strings in the format "HH:MM", where HH is the hour
    :param dailyBounds: a list of two strings representing the start and end of the day
    """
    updatedCalendar = calendar[:]
    updatedCalendar.insert(0, ["0:00", dailyBounds[0]])
    updatedCalendar.append([dailyBounds[1], "23:59"])
    return list(map(lambda m: [timeToMinutes(m[0]), timeToMinutes(m[1])], updatedCalendar))

def mergeCalendar(calendar1, calendar2):
    """
    We keep track of two pointers, one for each calendar, and we add the meeting with the earlier start
    time to the merged calendar
    
    :param calendar1: a list of tuples, where each tuple is an event. The first element of the tuple is
    the start time of the event, and the second element of the tuple is the end time of the event
    :param calendar2: [[1, 3], [5, 7]]
    :return: A list of tuples.
    """
    merged = []
    i, j = 0, 0
    while i < len(calendar1) and j < len(calendar2):
        meeting1, meeting2 = calendar1[i], calendar2[j]
        if meeting1[0] < meeting2[0]:
            merged.append(meeting1)
            i += 1
        else:
            merged.append(meeting2)
            j += 1
    while i < len(calendar1):
        merged.append(calendar1[i])
        i += 1
    while j < len(calendar2):
        merged.append(calendar2[j])
        j += 1
    return merged

def flattenCalendar(calendar):
    """
    If the current meeting starts before the previous meeting ends, merge the current meeting with the
    previous one. Otherwise, add the current meeting by itself
    
    :param calendar: [[0, 1], [3, 5], [4, 8], [10, 12], [9, 10]]
    :return: a list of lists.
    """
    flattened = [calendar[0][:]]
    for i in range(1, len(calendar)):
        currentMeeting = calendar[i]
        previousMeeting = flattened[-1]
        print(currentMeeting)
        currentStart, currentEnd = currentMeeting
        print(currentStart)
        previousStart, previousEnd = previousMeeting
        if previousEnd >= currentStart:
            newPreviousMeeting = [previousStart, max(previousEnd, currentEnd)]
            flattened[-1] = newPreviousMeeting
        else:
            flattened.append(currentMeeting[:])
    return flattened

def getMatchingAvailabilities(calendar, meetingDuration):
    """
    We iterate through the calendar, and for each pair of consecutive meetings, we check if the time
    between the meetings is greater than or equal to the meetingDuration. If it is, we add that time to
    matchingAvailabilities
    
    :param calendar: A list of pairs. Each pair is an event. The first item in the pair is the start
    time of the event. The second item in the pair is the end time of the event. All events are in
    chronological order, and all times in the calendar are in the same day. Each time
    :param meetingDuration: 30
    :return: A list of lists of strings.
    """
    matchingAvailabilities= []
    for i in range(1, len(calendar)):
        start = calendar[i - 1][1]
        end = calendar[i][0]
        availabilityDuration = end - start
        if availabilityDuration >= meetingDuration:
            matchingAvailabilities.append([start, end])
    return list(map(lambda m: [minutesToTime(m[0]), minutesToTime(m[1])], matchingAvailabilities))

def timeToMinutes(time):
    """
    It takes a string in the format "HH:MM" and returns the number of minutes since midnight
    
    :param time: The time in the format HH:MM
    :return: the total number of minutes in the time.
    """
    hours, minutes = list(map(int, time.split(":")))
    return hours * 60 + minutes

def minutesToTime(minutes):
    """
    It takes a number of minutes and returns a string in the format "HH:MM" where HH is the number of
    hours and MM is the number of minutes
    
    :param minutes: The number of minutes to convert to a time string
    :return: a string of the hours and minutes in the format "hours:minutes"
    """
    hours = minutes // 60
    mins = minutes % 60
    hoursString = str(hours)
    minutesString = "0" + str(mins) if mins < 10 else str(mins)
    return hoursString + ":" + minutesString