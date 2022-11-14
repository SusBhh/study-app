# study-app

### Outline
- Login Activity: use Google’s OAuth 2.0 for sign-in
- Profile/Settings Activity: change name, profile picture, reset food count
- Home/Shelf Activity:
  - Shelf asset with different foods displayed (just for aesthetic)
  - Timer: to indicate amount of study time (button to activity)
    - Upon clicking timer, user can type a number of minutes to study in a textfield
goes to a Timer activity with alarm clock animation and time countdown
    - After timer goes off, a food item will finish cooking
    - Specific food is based on the time user studied
    - Food Surface View: a surface view of the finished food is shown
      - Message on surface view
      - ie. Time for the user to take a break! Go touch grass or have a snack!
- Cookbook: see how much of each food they’ve cooked (button to activity)
    - Each food item appears in cookbook, along with the number of times the item has been “cooked,” or obtained by the user
    - Food item also displays amount of cooking (or studying) time needed to cook it
- Shopping list (stretch goal): act as a to-do list for user (button to activity)
    - upon clicking shopping list, user can input tasks they want to do
- Photo frame (stretch goal): user uploaded photos/motivation to study
