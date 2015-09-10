# distribution

# TODO

## high

* Some bundles kept in state "starting.
  This needs further inspection, perhaps the usage of Require-Bundle is the
  trigger.
  The ESH team decided not changing the model bundles:
  https://bugs.eclipse.org/bugs/show_bug.cgi?id=476024#c7
* There is a problem with Jersey and at least the PaperUI.
  https://github.com/hstaudacher/osgi-jax-rs-connector/issues/106

## normal

* Test on windows machine (e.g. bin/setenv.bin for http(s) port)
* The bundle org.openhab.core.init contains the logging stuff only. This one is
  not needed for Karaf anymore. Should we remove the whole bundle or leave it
  empty.
* Use at least as much Karaf features / bundles as possible.
  The bundles in the feature openhab2-runtime-split-tp should be replaced with
  dependencies to other Karaf features (e.g. http for jetty).
* The temporary Maven Repo in my (maggu2810) Github account MUST be replaced.

## low

# not supported on upstream openHAB, but should be done
* system property for keystore location (jetty)
