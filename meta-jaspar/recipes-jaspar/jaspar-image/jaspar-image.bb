SUMMARY = "Main Jaspar image"

IMAGE_FEATURES += "splash package-management x11-base x11-sato hwcodecs"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_EXTRA_SPACE = "100000"

IMAGE_INSTALL += " \
	packagegroup-core-x11-sato-base \
  openssh \
  takao-fonts \
  alsa-utils \
	matchbox-terminal \
	kernel-modules linux-firmware \
	connman connman-tools connman-client \
	bluez5-testtools \
	epiphany jaspar wds \
	gmediarender gupnp-tools \
	matchbox-wm \
	tcpdump \
	"
