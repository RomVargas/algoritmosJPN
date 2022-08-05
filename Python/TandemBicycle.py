def tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest):
    redShirtSpeeds.sort()
    if fastest == True:
        blueShirtSpeeds.sort(reverse=True)
    else:
        blueShirtSpeeds.sort()

    speed = 0

    for blueShirt, redShirt in zip(blueShirtSpeeds, redShirtSpeeds):
        speed += max(blueShirt, redShirt)

    return speed