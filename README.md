## KAT-P Pump diagnosis expert system
1. The program will diagnose a centrifugal pump.
2. Based on the parameters it monitors, the expert system will list the problems of the pump.
3. As an extension, the expert system will provide solutions to the problems.

#### Prototype submission
Currently, the system is capable of storing knowledge regarding the pump in a knowledge base implemented using the Drools Business inference engine. The system is capable of updating state of the pump based on questions answered by the user. Moreover, the system is able to follow rules defined using Drools. In order to exemplify this, we included an example of such a rule contained in Sample.drl. Based on the user's answer, the system should be able to select the next most relevant question using forward or backward chaining. In our current submission the system is able to choose the most relevant question without Drools. The implementation is done using our own methodology in Java. We will have a discussion with the T.A. in order to determine whether our implementation is correct.

Please find attached to this submission a runnable jar file as well as screenshots with the system in the case that you encounter issues running the system. Should you encounter issues running the jar file we will be at the tutorial on Wednesday (12.12.2018) to showcase the system.

#### TODO
1. Refactor view classes.
2. Validate system with expert.
3. USE STACK to switch scenes (next, previous)

#### Screenshots
![titlescreen](https://raw.githubusercontent.com/uberVelocity/KATP-pump-diagnosis/development/titlescreen.png)
![vibratingscreen](https://raw.githubusercontent.com/uberVelocity/KATP-pump-diagnosis/development/vibrating.png)
![rpmscreen](https://raw.githubusercontent.com/uberVelocity/KATP-pump-diagnosis/development/rpm.png)
