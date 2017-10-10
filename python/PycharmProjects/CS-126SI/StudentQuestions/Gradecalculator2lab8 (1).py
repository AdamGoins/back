inputfile = open('input.txt', 'r')

def read_grade_data(inputfile):
    grades_dict = {}

    # for loop and split on each line
    for i in inputfile:
        actual_points_earned = []
        points_possible = []
        # have it check each line individually
        # add to the dictionary with the names as the keys
        strippedline = i.strip()
        splitline = strippedline.split(" ",2)
        raw_data = ''.join(splitline[2:])
        # raw data gives the test scores
        catagories = ''.join(splitline[:1])
        # catagories gives the category
        weight = ''.join(splitline[1:2])
        # weight gives the weight
        second_splitline = raw_data.split(",")
        # second splitline seperates the data into a list
        points = "/".join(second_splitline)
        points = points.replace(" ","")
        # points turns it back into a string to be split
        points_earned = points.split("/")
        # points earned is the final modification to the raw data
        # take every other element in points earned for the actual amount
        # of points earned
        # take the opposite elements in points earned for the total possible
        # third_splitline = catagories.split(",")
        # splits catagories into a seperate list to be used as keys
        # fourth_splitline = weight.split(",")
        # splits the weight into a seperate list
        for score in range(len(points_earned)):
            if score % 2 == 1:
                points_possible.append(points_earned[score])
            elif score % 2 == 0:
                actual_points_earned.append(points_earned[score])
            # the code above gives us all the scores, going to be the values.
        grades_dict[catagories] = [weight,[actual_points_earned,points_possible]]
        # also gives us the seperated category and weight

        #hw_percent = percentage_per_category(grades_dict, "Homework")
        #quiz_percent = percentage_per_category(grades_dict, "Quiz")

    return grades_dict


def percentage_per_category(grades_dict, key):
    # takes in scores and returns percentage of points earned
    # calculates percentage of possible points earned in a category
    # score total divided by max list total

    value = grades_dict[key]
    points_earned = value[1][0]

    earned_total = 0
    for element in points_earned:
        earned_total += int(element)

    output_to_html(grades_dict,1, 3, 4)
def output_to_html(grades_dict,percent,letter_grade,weightedScore):
    fh = open("test.html", "w")
    fh.write("<html>")
    for section in grades_dict:
        string = "<h1>" + grades_dict[1] + "(" + grades_dict[section][0] + ")</h1>" + "<ul>"
        "<li><b>Average:</b>""</li>"
        "<li><b>Letter Grade:</b></li>"
        "<li><b>Overall Grade Contribution:</b></li>"
        "</ul></html>"
        fh.write(string)
    fh.close()
#def catagorize_data(list_of_catagories,list_of_weights,list_of_scores):
    #grades_dict = {}
    #actual_points_earned = []
    #points_possible = []
    #for score in range(len(points_earned)):
        #if score % 2 == 1:
            #points_possible.append(points_earned[score])
        #elif score % 2 == 0:
            #actual_points_earned.append(points_earned[score])



print(read_grade_data(inputfile))

inputfile.close()
