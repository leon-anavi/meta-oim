DESCRIPTION = "OpenIVI Mobility HTML5 environment"
HOMEPAGE = "https://openivimobility.github.io/"
SECTION = "base"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4641e94ec96f98fabc56ff9cc48be14b"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = " \
	git://github.com/openivimobility/openivi-html5.git;branch=master;tag=b55b140655030cfd10f2f8d24befb80f57c75874 \
	file://0001-CMakeLists.txt-Disable-X11.patch \
"

inherit pkgconfig cmake_qt5 externalsrc
PV = "0.1"
PR = "r0"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "qtbase qtwebkit"
DEPENDS = "qtbase-native qtbase qtwebkit ctags "

FILES_${PN} = "/usr/bin/openivi-html5 /usr/share/openivi/*"

do_install() {
  install -d ${D}${bindir}
  install -m 0755 openivi-html5 ${D}${bindir}

  install -d ${D}${datadir}/openivi/
  cp -r ${S}/example ${D}${datadir}/openivi/
}
