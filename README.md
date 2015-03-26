# intellij_plugin

Simple IntelliJ plugin, it adds an item to the main menu bar.
It can connect with a server that is able to respond with JSON response like this: {"msg": "sample text"}.

#### First run:

This project is a IntelliJ IDEA Plugin, so an only IDE you can use is IntelliJ IDEA, be sure to perform all the steps described below:

* This plugin needs a runtime environment. To configure it, you need a source code of IntelliJ IDEA Community Edition, please clone [this repository](http://www.jetbrains.org/pages/viewpage.action?pageId=983225) on your machine.

* Run your IntelliJ you use usaually, now you should configure IntelliJ IDEA SDK. You can follow steps described [here](https://confluence.jetbrains.com/display/IDEADEV/Getting+Started+with+Plugin+Development).
You should do all the things listed in Configuring IntelliJ IDEA SDK section.

* Now you should be able to open this plugin project, just simply use Open file or Project and point to the driectory where you have this plugin cloned.

* To run plugin hit Run button - default run configuration is enough. It should use IntelliJ IDEA SDK and open a new IntelliJ IDEA instance. You will see IntelliJ IDEA Community Edition windowd with a new button on main toolbar menu.

#### IMPORTANT!
To see how it this plugin work you need to have [intellij_plugin_server](https://github.com/BartoszJanota/intellij_plugin_server) deployed. Please follow steps described in inellij_plugin_server README to run it locally.

Enjoy :)
