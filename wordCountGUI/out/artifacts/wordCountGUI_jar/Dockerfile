FROM debian:stretch

ENV LC_ALL en_US.UTF-8
ENV LANG en_US.UTF-8

RUN apt-get update && apt-get install -y \
	apt-transport-https \
	ca-certificates \
	curl \
	gconf2 \
	gconf-service \
	gvfs-bin \
	hunspell-en-us \
	libasound2 \
	libgtk2.0-0 \
  openjdk-8-jdk \
	libnotify4 \
	libnss3 \
	libxss1 \
	libxtst6 \
	locales \
	xdg-utils \
        libgnome-keyring0 \
        gir1.2-gnomekeyring-1.0 \
        libappindicator1 \
	--no-install-recommends \
	&& rm -rf /var/lib/apt/lists/*
RUN apt install libxtst6
COPY . /Users/adamnash/wordCountGUI/out/artifacts/wordCountGUI_jar/
WORKDIR /Users/adamnash/wordCountGUI/out/artifacts/wordCountGUI_jar/
RUN java -version
CMD ["java", "-jar", "wordCountGUI.jar"]
