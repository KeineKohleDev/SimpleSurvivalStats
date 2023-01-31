package net.keinekohle.simplestats.config;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import net.keinekohle.simplestats.util.Constance;

import java.io.File;
import java.io.IOException;

public class Language
{
    private static Language language;
    private YamlDocument SETTINGS;

    public static Language getInstance()
    {
        return language == null ? language = new Language() : language;
    }

    private Language ()
    {
        try
        {
            this.SETTINGS = YamlDocument.create(new File(Constance.PATH_TO_LANG_FILE), Language.class.getResourceAsStream(Constance.LANG_FILE_NAME), GeneralSettings.DEFAULT, LoaderSettings.builder().setAutoUpdate(true).build(), DumperSettings.DEFAULT, UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build());
            this.SETTINGS.update(Language.class.getResourceAsStream(Constance.LANG_FILE_NAME));
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String getSetting (LanguageValues settings)
    {
        return this.SETTINGS.getString(settings.name());
    }
}
