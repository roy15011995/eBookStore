package com.aroy.ebookstore.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.example.composebookstoreapplication.model.AccessInfo
import com.example.composebookstoreapplication.model.BookItems
import com.example.composebookstoreapplication.model.Epub
import com.example.composebookstoreapplication.model.ImageLinks
import com.example.composebookstoreapplication.model.IndustryIdentifiers
import com.example.composebookstoreapplication.model.PanelizationSummary
import com.example.composebookstoreapplication.model.Pdf
import com.example.composebookstoreapplication.model.ReadingModes
import com.example.composebookstoreapplication.model.SaleInfo
import com.example.composebookstoreapplication.model.SearchInfo
import com.example.composebookstoreapplication.model.VolumeInfo

/**
 * Created by Amit Roy on Date : 26/11/25
 *
 *
 * Common [TypeConverter] for Room database.
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