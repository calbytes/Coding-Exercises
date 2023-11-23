#CodingBat Logic-2 > make_bricks

def make_bricks_with_resursion(small, big, goal):
    if small < 0 or big < 0 or goal < 0:
        return False
    if goal == 0:
        return True
  
    return make_bricks_with_resursion(small, big-1, goal-5) or make_bricks_with_resursion(small-1, big, goal-1)

def make_bricks(small, big, goal):
    if big > 0: 
        floor = goal // 5
    if floor > big:
        goal -= big*5
    else:
        goal -= floor*5
    
    if small >= goal:
        return True
    
    return False

print('wRecursion: ' + str(make_bricks_with_resursion(5, 3, 16)))

print('wModulus: ' + str(make_bricks(0, 5, 19)))




