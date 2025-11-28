package com.aroy.ebookstore.core

import androidx.room.TypeConverter
import com.aroy.ebookstore.model.AccessInfo
import com.aroy.ebookstore.model.BookItems
import com.aroy.ebookstore.model.Epub
import com.aroy.ebookstore.model.ImageLinks
import com.aroy.ebookstore.model.IndustryIdentifiers
import com.aroy.ebookstore.model.PanelizationSummary
import com.aroy.ebookstore.model.Pdf
import com.aroy.ebookstore.model.ReadingModes
import com.aroy.ebookstore.model.SaleInfo
import com.aroy.ebookstore.model.SearchInfo
import com.aroy.ebookstore.model.VolumeInfo
import com.google.gson.Gson

/**
 * Created by Amit Roy on Date : 26/11/25
 *
 *
 * Common [androidx.room.TypeConverter] for Room database.
 *
 * This class provides custom type converters for Room so that complex data types
 * (such as lists and nested objects) can be stored in the database as JSON strings.
 *
 * Room only supports primitive types (Int, String, Boolean, etc.) by default.
 * To persist objects like [BookItems], or [List<String>],
 * we serialize them into JSON using Kotlinx Serialization and store them as TEXT.
 * When reading from the database, the JSON is deserialized back into the original type.
 *
 * Usage:
 * - Register this class in your RoomDatabase with `@TypeConverters(Converters::class)`
 * - Annotate entity fields with `@TypeConverters` if they require conversion
 *
 * Example:
 * ```
 * @Database(entities = [BookResponseEntity::class], version = 1)
 * @TypeConverters(Converters::class)
 * abstract class AppDatabase : RoomDatabase() {
 *     abstract fun bookResponseDao(): BookResponseDao
 * }
 * ```
 */
object Converters {
    private val gson = Gson()

    @TypeConverter
    fun saveVolumeInfo(volumeInfo: VolumeInfo?): String? =
        volumeInfo?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreVolumeInfo(volumeInfoString: String?): VolumeInfo? =
        volumeInfoString?.let { gson.fromJson(it, VolumeInfo::class.java) }

    @TypeConverter
    fun saveSaleInfo(saleInfo: SaleInfo?): String? =
        saleInfo?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreSaleInfo(saleInfoString: String?): SaleInfo? =
        saleInfoString?.let { gson.fromJson(it, SaleInfo::class.java) }

    @TypeConverter
    fun saveAccessInfo(accessInfo: AccessInfo?): String? =
        accessInfo?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreAccessInfo(accessInfoString: String?): AccessInfo? =
        accessInfoString?.let { gson.fromJson(it, AccessInfo::class.java) }

    @TypeConverter
    fun saveSearchInfo(searchInfo: SearchInfo?): String? =
        searchInfo?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreSearchInfo(searchInfoString: String?): SearchInfo? =
        searchInfoString?.let { gson.fromJson(it, SearchInfo::class.java) }

    @TypeConverter
    fun saveBookItems(bookItems: List<BookItems>?): String? =
        bookItems?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreBookItems(bookItemsString: String?): List<BookItems>? =
        bookItemsString?.let { gson.fromJson(it, Array<BookItems>::class.java).toList() }

    @TypeConverter
    fun saveEpub(epub: Epub?): String? =
        epub?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreEpub(epubString: String?): Epub? =
        epubString?.let { gson.fromJson(it, Epub::class.java) }

    @TypeConverter
    fun savePdf(pdf: Pdf?): String? =
        pdf?.let { gson.toJson(it) }

    @TypeConverter
    fun restorePdf(pdfString: String?): Pdf? =
        pdfString?.let { gson.fromJson(it, Pdf::class.java) }

    @TypeConverter
    fun saveStringList(list: List<String>?): String? =
        list?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreStringList(value: String?): List<String>? =
        value?.let { gson.fromJson(it, Array<String>::class.java).toList() }


    @TypeConverter
    fun saveIndustryIdentifiers(industryIdentifiers: List<IndustryIdentifiers>?): String? =
        industryIdentifiers?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreIndustryIdentifiers(industryIdentifiersString: String?): List<IndustryIdentifiers>? =
        industryIdentifiersString?.let { gson.fromJson(it, Array<IndustryIdentifiers>::class.java).toList() }

    @TypeConverter
    fun saveImageLinks(imageLinks: ImageLinks?): String? =
        imageLinks?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreImageLinks(imageLinksString: String?): ImageLinks? =
        imageLinksString?.let { gson.fromJson(it, ImageLinks::class.java) }

    @TypeConverter
    fun savePanelizationSummary(panelizationSummary: PanelizationSummary?): String? =
        panelizationSummary?.let { gson.toJson(it) }

    @TypeConverter
    fun restorePanelizationSummary(panelizationSummaryString: String?): PanelizationSummary? =
        panelizationSummaryString?.let { gson.fromJson(it, PanelizationSummary::class.java) }

    @TypeConverter
    fun saveReadingModes(readingModes: ReadingModes?): String? =
        readingModes?.let { gson.toJson(it) }

    @TypeConverter
    fun restoreReadingModes(readingModesString: String?): ReadingModes? =
        readingModesString?.let { gson.fromJson(it, ReadingModes::class.java) }

}