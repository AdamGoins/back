def format(date):


    year = date[0:4]

    month = date[4:6]

    day = date[6:]

    months = ["January", "February", "March", "April", "May", "June", "July", "August",
              "September", "October", "November", "December"]

    month_string = months[int(month) - 1]

    true_date = month_string + " " + day + ", " + year
    return true_date


date1 = "20170207"
date2 = "19940323"
date3 = "20120524"

print("Date 1: " + format(date1))
print("Date 2: " + format(date2))
print("Date 3: " + format(date3))