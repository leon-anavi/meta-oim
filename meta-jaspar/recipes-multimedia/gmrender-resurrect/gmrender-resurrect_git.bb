SUMMARY = "Headless UPnP Renderer"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=4325afd396febcb659c36b49533135d4"

SRC_URI = "git://github.com/cajun-rat/gmrender-resurrect.git \
	   file://gmrender-resurrect.sh \
	   file://gmrender-resurrect.service"

SRCREV = "99be5e0b39ed5be4367f8187a97b6fc57ce3ed74"
PV= "0.0.0+gitr${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad \
	   libupnp"

inherit autotools pkgconfig systemd

SYSTEMD_SERVICE_${PN} = "gmrender-resurrect.service"
FILES_${PN} += "/usr/share/gmediarender"
FILES_${PN} += "/usr/lib/gmediarender"

do_install_append() {
	if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
		install -d ${D}/${systemd_unitdir}/system
		install -m 644 ${WORKDIR}/gmrender-resurrect.service \
			${D}/${systemd_unitdir}/system
		install -d ${D}/usr/lib/gmediarender
		install -m 755 ${WORKDIR}/gmrender-resurrect.sh \
			${D}/usr/lib/gmediarender
	fi
}