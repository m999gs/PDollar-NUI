# PDollar-NUI

**NAME: Mohit Garg**</br>
**Gatorlink name: mohitgarg**</br>
## How to Execute
step 1: change directory to src:</br>
**`$ cd src`** </br></br>
step 2: run the code:</br>
**`$ make clean`**</br>
**`$ make`**       </br>
`$ java pdollar -t <Gesture file location> (to add gesture file)`</br>
**`$ java pdollar <Eventstream file location>(to recognize the input file for gesture)`**</br>
`$ java pdollar -r                         (to remove the gesture)`</br>
`$ java pdollar                            (for help commands)`</br>
## Example
```
cd src
make clean
make
java pdollar java pdollar gestureFiles/arrowhead.txt
java pdollar eventfiles/arrowhead_eventfile.txt
```
You can copy and paste the example commands directly to the terminal.
