<p align="center">
<img src="images/banner.jpg" width=750 align="center">
</p>

EMERNET E.I.N.S
=====
EMERNET E.I.N.S (Emergency Information Network System) was created to provide important information in case of a complete communication network failure.<br>
EMERNET provides information like important Telephone numbers, emergency news applications (ex. NINA) and emergency services (ex. shelter locations).<br>
All information provided is managed by the Open Source Community on GitHub and EMERNET-EINS.org.<br>
EMERNET is frequently updated to provide the latest information.


## EMERNET Server
This repository serves the server executable. This Application does the setup process for you.

All you have to do is download a pre-built jar (or build it your self), upload it to a server and execute it.

After installing it successfully, you should have a fully working EMERNET E.I.N.S Instance hosted on your device.

### Requirements
**This server runtime only works on Linux devices!**
This runtime was originally intended to be deployed on something like a Raspberry Pi, something that is low powered and can be placed anywhere in the house.

- A Linux device (Raspberry Pi, anything else that runs Linux)
- An Internet connection to set it up (and get updates)
- A WiFi network where other devices can access the web pages served

### Setup process

#### 1. Download the latest Setup/Server Client
To start off, please head to the [releases page](https://github.com/emernet-eins/server/releases) and download a pre-built jar.

*If you dont trust us for some reason, feel free to download the latest released source code and build it your self*.

#### 2. Put the jar on your server
Next step is to upload the jar to the machine where EMERNET E.I.N.S should be deployed.

#### 3. Execute the Setup/Server Client
To start, execute the runtime with root privileges.
```bash
sudo java -jar emernet-runtime_X.jar
```

The setup will start to install all the required packages, applications and websites to your device.

**Packages that will be installed**
- Apache2
- More coming soon (<a href="#future">Click here for more information</a>)

**What this setup does**
- Downloads the latest version of EMERNET E.I.N.S System
- Installs an (Apache) Web server
- Creates Apache Config
- Sets the access rights

#### 4. Finish
Now the EMERNET E.I.N.S runtime is deployed successfully.

The runtime will check for updates every 24 hours to provide the latest information.

### Contributing
If you have any addition to the runtime that should be built in, feel free to fork the repository, implement the feature and create a pull request. We will review your changes and might even merge it.

### Troubleshooting
If there is anything wrong with the setup, runtime it self or updating, please open an issue [here](https://github.com/emernet-eins/server/issues)

### Disclaimer
This runtime/setup is currently still in beta and not fully tested. We urge you to try this setup on a device, which does NOT run any important applications or has valuable data on it to prevent data loss in case of an error. If there is anything wrong with the runtime/setup please open an issue [here](https://github.com/emernet-eins/server/issues).

<p id="future"></p>
## A quick look into the future
We are planning big for this project.

In the future, we want to create a Raspberry Pi only version that even sets up a custom WiFi Hotspot. With that you will be able to just join the open network and access the data more easily.

More stuff will be added in the future.

**If you have any idea, feel free to open a feature request.**