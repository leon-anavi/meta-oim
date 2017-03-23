DESCRIPTION = "dzen is a general purpose messaging, notification and menu program."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=6b46e938a20b07191fa895000af16167"
DEPENDS = "virtual/libx11 libxft"
RDEPENDS_${PN} = "ttf-dejavu-sans xrandr"

PR = "r4"
EXTRA_OEMAKE = 'all -C ${S}'

SRC_URI = "https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/dzen/dzen2-${PV}.tar.gz \
          file://dzen-extras.tar.gz \
          file://Makefile"

S = "${WORKDIR}/dzen2-${PV}"

FILES_${PN} = "/usr/bin /usr/share/dzen"

LDFLAGS += "-pthread"

do_configure() {
	install -m 0644 ${WORKDIR}/Makefile ${S}/Makefile
	cat <<EOF > config.mk
VERSION = ${PV}

PREFIX = /usr
MANPREFIX = /usr/share/man

INCS = -DDZEN_XFT -DVERSION=\"${PV}\" `pkg-config --cflags xft` 
LIBS = -lc -lX11 `pkg-config --libs xft`
EOF
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "d1ecf6607e66dc53d030bb32a75f6be6"
SRC_URI[sha256sum] = "793840866b4f297fe99e4c632f8d3d0fcff2618c889bf384b48f7d4db5a23337"
